# AndroidSwayAnimation

<img src="/SwayAnim1.gif" width="35%"> <img src="/SwayAnim2.gif" width="35%">

This is subtle gif. Check smoothness with video.

[Sample](https://www.youtube.com/watch?v=XECWjK18ppE&feature=youtu.be) /
[Sample with RecyclerView](https://www.youtube.com/watch?v=vyBPNVYK6JU&feature=youtu.be)


## Download

```build.gradle
dependencies {
    compile 'com.kidach1:AndroidSwayAnimation:1.0.5'
}
```


## Usage

```java
// In your Activity
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RelativeLayout animatedZone = (RelativeLayout) findViewById(R.id.animatedLayout);
    RelativeLayout touchZone = (RelativeLayout) findViewById(R.id.touchedLayout);
    SwayAnimation.ready(animatedZone, touchZone, this);
}
```

## Advanced

### custom drawables for animation

```java
SwayAnimation.setDrawables(Arrays.asList(
        R.drawable.ic_favorite_pink_300_48dp,
        R.drawable.ic_tag_faces_amber_300_48dp,
        R.drawable.ic_thumb_up_blue_a200_48dp
));
SwayAnimation.ready(animatedZone, touchZone, this);
```

### if you use ActionBar (but not Toolbar)

```java
SwayAnimation.setWithActionBar(true);
SwayAnimation.ready(animatedZone, touchZone, this);
```


License
-------

    Copyright 2015 kidach1

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.