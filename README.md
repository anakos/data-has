# data-has

This is a scala port of the Haskell library of [the same name](https://hackage.haskell.org/package/data-has), providing a few additional helper methods for convenience: these helper methods explicitly target programs structured around [`ReaderT over IO`](https://www.fpcomplete.com/blog/2017/06/readert-design-pattern), where the IO monad is provided by cats-effect.

## Motivation

Programs are expressed in terms of various capabilities: the capability to read data from Kafka, the capability to write data to Postgres, &c.

One way of structuring the outermost layer of your program is via `ReaderT over IO`.  We can bestow capabilities on this data-structure in an additive manner by leveraging implicit scope to place constraints on it's input parameter. 

The Has trait defined in this library can help facilitate this, allowing for maximum reuse across applications.

## Usage / Examples

TBD