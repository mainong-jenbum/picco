# Picco

*Pick a date or a time in a new way* \
A simple library to display toast messages with custom background and icon.

## How to

1. Add the JitPack repository to your build file.\
*Add it in your root build.gradle at the end of repositories*


```gradle
allprojects {
   repositories {
        ...
	    maven { url 'https://jitpack.io' }
   }
}
```

2. Add the dependency

```gradle
dependencies {
	implementation 'com.github.mainong-jenbum:pop:1.2.0'
}

```

## Usage

* Calendar
```java
Pico pico = new Pico(context, null, Type.CALENDAR);
        pico.setPicoListener(new PicoListener() {
            @Override
            public void result(Calendar calendar) {
            
                // Getting your date
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
            
                // Displaying toast message using Pop library
                Pop.info(context, Pico.formatDate(calendar));
            }
        });
 pico.show();
```
![date](https://user-images.githubusercontent.com/23124053/58634534-26c68700-8309-11e9-9fd8-89c53a669fc5.png)

* Time
```java
Pico pico = new Pico(context, null, Type.TIME);
        pico.setPicoListener(new PicoListener() {
            @Override
            public void result(Calendar calendar) {
           
                // Getting your time in 24 hour format
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);
                int sec = calendar.get(Calendar.SECOND);
                
                // Displaying toast message using Pop library
                Pop.info(context, Pico.formatTime(calendar));
                
            }
        });
 pico.show();
```
![time](https://user-images.githubusercontent.com/23124053/58634541-28904a80-8309-11e9-8d29-5937d5a831d8.png)


## FORMATTER
* Date\
*THU 12 FEB, 19*
```java
String formattedDate = Pico.formatDate(calendar);
```


* Time\
*12:35:02 AM*
```java
String formattedTime = Pico.formatTime(calendar);
```
