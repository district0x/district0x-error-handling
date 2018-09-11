# district0x/error-handling

<!-- [![Build Status](https://travis-ci.org/district0x/error-handling.svg?branch=master)](https://travis-ci.org/district0x/error-handling) -->

Clojurescript library with functions aiding in error handling.
This module currently utilises [timbre](https://github.com/ptaoussanis/timbre) as a logging library.

## Installation
Add `[district0x/error-handling "1.0.0"]` into your project.clj. <br>
Include `[district.shared.error-handling]` in your CLJS file. <br>
<br>

**Warning:** district0x modules are still in early stages, therefore API can change in a future.

## district.shared.error-handling
**`try-catch`** <br>
* wraps around a function body and logs any exception being thrown.

**`try-catch-throw`**
* wraps around a function body logs any exception being thrown and then re-throws it for further handling.

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
For configuration options please see [district-server-logging](https://github.com/district0x/district-server-logging). <br>
<br>

If you wish to use custom modules instead of dependencies above while still using `district-server-logging`, you can easily do so by [mount's states swapping](https://github.com/tolitius/mount#swapping-states-with-states).
