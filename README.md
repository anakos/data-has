# data-has

This is a scala port of the Haskell library of [the same name](https://hackage.haskell.org/package/data-has), providing a few additional helper methods for convenience: these helper methods explicitly target programs structured around [`ReaderT over IO`](https://www.fpcomplete.com/blog/2017/06/readert-design-pattern), where the IO monad is provided by cats-effect.

## Usage / Examples