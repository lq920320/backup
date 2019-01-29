enter redis directory

### start server
-   `.\redis-server.exe redis.windows.conf`

### connect server
-   `.\redis-cli.exe -h 127.0.0.1 -p 6379`

### set value
-   `set KEY_NAME VALUE`

### get value
1. unstructured          
   - `get KEY_NAME`
2. structured          
   - `hgetall KEY_NAME`
   
### delete value
-   `del KEY_NAME`
