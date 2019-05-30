# Picco

*Pick a date or a time in a new way* \
A simple library to pick your desired date or time in a new way.

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
	implementation 'com.github.mainong-jenbum:picco:v1.5.0'
}

```

## Usage

### Calendar
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
![date_picker](https://user-images.githubusercontent.com/23124053/58652787-f9420380-8331-11e9-87a0-e451e040982f.png)

### Time
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
![time_picker](https://user-images.githubusercontent.com/23124053/58652793-fc3cf400-8331-11e9-97d8-7c546c168d12.png)


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
