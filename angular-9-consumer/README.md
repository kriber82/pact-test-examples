# Pact Test Example

This project was forked from https://github.com/danymarques/pact-test-example.
There is also an accompanying blog post: https://medium.com/@dany.marques/how-to-set-up-pact-tests-with-angular-jest-ae157f272428.
Thanks to dannymarques for the great example how to get pact working with more recent angular versions.

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 9.0.5.

## Prerequisites

- For gyp (which is needed by pact):
    - A working python installation
    - A working C++ build chain
    - For more details check out https://github.com/nodejs/node-gyp#installation
- On Windows:
    - clone the repo into a short path (i.e. C:\dev\pact) (for details: https://github.com/pact-foundation/pact-js-core/issues/200)

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running tests

Run `npm run test` to execute the unit and the Pact tests with Jest.

## Running Pact Test individually

Run `npm run test:pact` to execute Pact tests.
