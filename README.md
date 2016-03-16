

[![Video](/SwayAnim2.gif)](https://www.youtube.com/watch?v=vyBPNVYK6JU&feature=youtu.be)


## Download

```build.gradle
dependencies {
    compile 'com.kidach1:AndroidSwayAnimation:1.0.5'
}
```


## Usage

```YourActivity.java
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

### for custom drawables

```YourActivity.java
SwayAnimation.setDrawables(Arrays.asList(
        R.drawable.ic_favorite_pink_300_48dp,
        R.drawable.ic_tag_faces_amber_300_48dp,
        R.drawable.ic_thumb_up_blue_a200_48dp
));
SwayAnimation.ready(animatedZone, touchZone, this);
```

### if you use ActionBar

```YourActivity.java
SwayAnimation.withActionBar(true);
SwayAnimation.ready(animatedZone, touchZone, this);
```


## You can use this with RecyclerView if you want.