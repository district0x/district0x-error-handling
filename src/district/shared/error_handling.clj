(ns district.shared.error-handling
  (:require [taoensso.timbre]
            [cljs.core]))

(defmacro error? [x]
  `(cljs.core/instance? js/Error ~x))

(defn compiletime-info
  [and-env and-form ns]
  (let [meta-info (meta and-form)]
    {:ns (str (ns-name ns))
     :line (:line meta-info)
     :file (:file meta-info)}))

(defmacro try-catch [& body]
  `(try
     ~@body
     (catch js/Object e#
       (taoensso.timbre/error "Unexpected exception" (merge {:error e#}
                                                            (ex-data e#)
                                                            ~(compiletime-info &env &form *ns*))))))

(defmacro try-catch-throw [& body]
  `(try
     ~@body
     (catch js/Object e#
       (taoensso.timbre/error "Unexpected exception" (merge {:error e#}
                                                            (ex-data e#)
                                                            ~(compiletime-info &env &form *ns*)))
       (throw (js/Error. e#)))))
