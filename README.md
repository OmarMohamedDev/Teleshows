# Teleshows
App that display a list of most popular Tv shows got from The Movie DB APIs (https://www.themoviedb.org/)

## Setup project
To get started and make the app running, first of all create an account on https://www.themoviedb.org/

Then, follow the instructions explained in the following page in order to create your own API Key to have 
access to The Movie DB APIs: https://developers.themoviedb.org/3/getting-started/introduction

Finally, just clone this project and create in the Teleshows project folder called "main" 
a folder called "assets" (if not present yet) and put inside the following file:

```
apikeys.properties
```

Inside, just add this line replacing {YOUR_API_KEY} with the one obtained in your account:

```
moviedb_apikey= {YOUR_API_KEY}
```

## Application structure inspired by
https://github.com/bufferapp/clean-architecture-components-boilerplate

## License
```
MIT License

Copyright (c) 2017 Omar Mohamed

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```