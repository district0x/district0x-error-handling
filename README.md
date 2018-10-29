# district0x/error-handling

Clojurescript library with functions aiding in error handling.
This library currently utilises [timbre](https://github.com/ptaoussanis/timbre) as a logging library.
You shoud use it in conjunction with the [district-server-logging](https://github.com/district0x/district-server-logging) and [district-ui-logging](https://github.com/district0x/district-ui-logging) modules which setup various logging appenders.

## Installation
Add `[district0x/error-handling "1.0.1-SNAPSHOT"]` into your project.clj. <br>
Include `[district.shared.error-handling]` in your CLJS file. <br>
<br>

## district.shared.error-handling
**`try-catch`** <br>
* Wraps around a function body and logs any exception being thrown.

**`try-catch-throw`**
* Wraps around a function body, logs any exception being thrown and then re-throws it for further handling.

## Usage

```clojure
(ns my-district
  (:require [district.shared.error-handling :refer [try-catch try-catch-throw]]))

(defn function-that-can-fail [n]
  (try-catch
   (/ 7 n)))
```

## Library dependencies

### [district-server-logging](https://github.com/district0x/district-server-logging)
`error-handling` requires a configured `district-server-logging` module to function correctly.
Depending on where the code is run and how the logging is configured your errors will be reported to the browser, node.js console, filebeat consumed file, [sentry](https://sentry.io) etc.
For possible configuration options please see [district-server-logging](https://github.com/district0x/district-server-logging). <br>
