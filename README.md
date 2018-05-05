[![dev: Build Status](https://travis-ci.org/glomex/content-sdk-android.svg?branch=dev)](https://travis-ci.org/glomex/content-sdk-android) [![Download](https://api.bintray.com/packages/glomex/maven/content-sdk/images/download.svg?version=0.1.3)](https://bintray.com/glomex/maven/content-sdk/0.1.3/link) [![License](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](LICENSE) ![Platform](https://img.shields.io/badge/platform-Android-lightgrey.svg)

# Content SDK
An SDK that offers easy access for developers to video sources and Glomex tracking events.

## Download

```
dependencies {
  implementation 'com.glomex:content-sdk:1.0.0'
}
```

## Integration
`ContentSdk.load()` is used to load content. `Content` is passed to `callback` if content loaded successfully or `error` will be executed with exception:
```kotlin
val config = ContentSdk.ContentConfig(
        integrationId = integrationId,
        contentId = contentId,
        pageUrl = pageUrl
)
ContentSdk.load(
        config = config,
        callback = { content -> ... },
        error = { error -> ... }
)
```

`Content` is used to get sources by `content.getSources()`

Track content events:
- `content.trackContentBegin()` to track content beginning event
- `content.trackAdBegin(AdType)` to track ad beginning event by type

## License
```
Copyright 2018 glomex GmbH 

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
