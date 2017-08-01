Doesn't include Redis.

### Notable files:

- `/main/resources/ehcache.xml`: configures the ehcache (cache name)
- `/main/java/app/config/EhCachingConfig.java`: ehCache integration configuration with Spring
- `/main/java/app/data/UserRepository.java` use of annotations on methods
- `/test/java/app/data/UsreRepositoryTest.java` Test class

### Notes

- @Cacheable vs @CachePut

  > @Cacheable looks for an entry in the cache first, preempting the method invocation if a matching entry is found. If no matching entry is found, the method is invoked and the value returned is put in the cache. 
  >
  > @CachePut, on the other hand, neverchecks for a matching value in the cache, always allows the target method to be invoked, and adds the returned value to the cache. 

  `@Cacheable` is good for `query` methods. As it executes a method only once. `@CachePut` is good for `update` methods, the *newer* object will be saved in the cache, and methods that query for it will have `@Cacheable` and will fetch it from cache.

  They both saves the returned object in the cache, so only methods with returning values can have them.

  @CacheEvict removes an object from cache. Good for delete/remove methods. Can be used on methods that returns `void`. 

- what's the default cache key? SIA page 371

- Set custom cache key P371

- conditional caching: unless vs condition P369 and P372 and P373