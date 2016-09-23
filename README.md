lorem-enhanced
=====

An extremely useful Lorem Ipsum generator for Java! A fork of project [lorem](https://github.com/mdeanda/lorem) (Many Thanks!).

### Getting Started:

Add this to gradle:
```gradle
compile 'com.github.nhalase:lorem-enhanced:1.0.0-SNAPSHOT'
```

Now prepare your implementation:
```java
Lorem lorem = LoremIpsum.getInstance();
// or
Lorem lorem = new LoremIpsum(long seed);
```



### Sample Usage:

#### Names

```java
lorem.getName();
```
Generates a random name.

```java
lorem.getNameFemale();
```
Generates a random female name.

```java
lorem.getFirstNameFemale();
```
Generates a random female first name (1000 possible values).

```java
lorem.getNameMale();
```
Generates a random male name.

```java
lorem.getFirstNameMale();
```
Generates a random male first name (899 possible values).

```java
lorem.getFirstName();
```
Generates a random first name (1,899 possible values).

```java
lorem.getLastName();
```
Generates a random last name (999 possible values).

```java
lorem.getUniversityName();
```
Generates a random university name (335,685 possible values).

```java
lorem.getSchoolName();
```
Generates a random school name (134,274 possible values).

```java
lorem.getCollegeName();
```
Generates a random college name (134,274 possible values).

```java
lorem.getDepartmentName();
```
Generates a random department name (134,274 possible values).


### Emails

```java
lorem.getEmail();
```
Generates a random email (e.g., getFirstName() + "." + getLastName() + "@" + "example.com").

```java
lorem.getEmail(String suffix);
```
Generates a random email (e.g., getFirstName() + "." + getLastName() + "@" + suffix).



#### Phone Numbers

```java
lorem.getPhone();
```
Generates a phone number in the form: `(800) 555-1212`



#### Locations

```java
lorem.getCity();
```
Generates a city name.

```java
lorem.getStateFull();
```
Generates a state name.

```java
lorem.getStateAbbr();
```
Generates a 2 letter state abbreviation.

```java
lorem.getZipCode();
```
Generates a 5-digit zip code.

```java
lorem.getCountry();
```
Generates a country name.