# dztoolbarlb

How to config to your project: 

Step 1. Add the JitPack repository to your build file
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
  
  Step 2. Add the dependency
  
  ```
  dependencies {
	        implementation 'com.github.dzungvu:dztoolbarlb:0.1.0'
	}
  ```

Toolbar for Android with 2 main part:
- Left and right view: It can be a image of text with badge number can be controlled.
- Center view: Contain title for toolbar.


Add view to xml file:
```
<com.vtdung.dztoolbar.dztoolbarlb.views.DzToolbar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/toolbar"/>
```

Functions instruction:


Get textview title of toolbar:
```
    getTvTitle()
```

Get textview left of toolbar:
```
    getTvLeft()
```

Get textview right of toolbar:
```
    getTvRight()
```

Set visible for badge number in the left side of toolbar:
```
    setVisibleLeftBadge(boolean isVisible)
```

Set visible for badge number in the right side of toolbar:
```
    setVisibleRightBadge(boolean isVisible)
```

Set number for badge number in the left side of toolbar:
```
    setLeftBadgeNumber (int number)
```

Set number for badge number in the right side of toolbar:
```
    setRightBadgeNumber (int number)
```

Add click listener for left and right size of tool bar:
```
    addClickListener(CustomToolbarClickListener clickListener)
```

Set text for title of toolbar:
```
    setTitle(String title)
```
