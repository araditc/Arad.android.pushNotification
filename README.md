Arad Push notification system
=======

A power full push message library for Android

![](https://i.ibb.co/R6xsgnJ/imageedit-24-6365187725.png)

Download
--------

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
 	 implementation 'com.github.araditc:pushNotification:1.0.5'
}
```

How do I use Arad Push notification?
-------------------

Simple use cases will look something like this:

```java
// For a simple view:
        DataObserver dataObserver = new DataObserver() {
            @Override
            public void onMessageReceived(Object message) {
//                do something

//
            }
        };

        AradPushNotification.registerDataObserver(dataObserver);


//      unregister your call back

        AradPushNotification.unregisterDataObserver(dataObserver);
       
```

License
--------

  
  Copyright 2020 Arad-Itc.
 
  Licensed under the Arad License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
  https://arad-itc.com/
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.

