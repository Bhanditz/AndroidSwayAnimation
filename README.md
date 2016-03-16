# AndroidSwayAnimation

<img src="/SwayAnim1.gif" width="35%"> <img src="/SwayAnim2.gif" width="35%">

Check more smoothness with video.

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

### custom drawables

```java
SwayAnimation.setDrawables(Arrays.asList(
        R.drawable.ic_favorite_pink_300_48dp,
        R.drawable.ic_tag_faces_amber_300_48dp,
        R.drawable.ic_thumb_up_blue_a200_48dp
));
SwayAnimation.ready(animatedZone, touchZone, this);
```

### if you use ActionBar (but not Toolbor)

```java
SwayAnimation.withActionBar(true);
SwayAnimation.ready(animatedZone, touchZone, this);
```
