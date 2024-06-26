## About

The ThreadLimits project tries to empirically determine how many threads can be created in a JVM with a given memory and CPU limit.
The goal is to prove that CPU has no impact on the amount of threads that can be created, while memory has a major impact.

The project create a new thread until it fails with OOM exception or JVM native one.
Counter for Every new thread is displayed in the console. E.g. last line with:

```New thread #6804.```

means that there were 6804 theads created before the JVM failed.

## Building

```bash
mvn clean package
docker build -t threadlimits .
```

## Running

Basic run with no limits:

```bash
docker run threadlimits
```

## Testing time!

Below are my results for three runs of the same docker command with memory/CPU limits added.
You may notice that for the same limit params I've got more or less similar results.

```bash
docker run --memory=256m --cpus="1.0" threadlimits
```
1) New thread #6804.
2) New thread #6812.
3) New thread #5825. 


```bash
docker run --memory=256m --cpus="8.0" threadlimits
```

1) New thread #6637
2) New thread #7575
3) New thread #7588

```bash
docker run --memory=512m --cpus="1.0" threadlimits
```

1) New thread #12907
2) New thread #12704
3) New thread #12820

```bash
docker run --memory=512m --cpus="8.0" threadlimits
```

1) New thread #13643
2) New thread #12676
3) New thread #13468

```bash
docker run --memory=1024m --cpus="1.0" threadlimits
```

1) New thread #26186
2) New thread #25297
3) New thread #25521


```bash
docker run --memory=1024m --cpus="8.0" threadlimits
```

1) New thread #26871
2) New thread #26699
3) New thread #26185


### Conclusion

Although the results may vary depending on the machine you're running the tests on, you should be able to see the overall trend.
Rising the memory for the JVM allows for more threads to be created, while CPU has no visible impact on that amount.
