
// class LRUCache {
//     int capacity = 0;
//     Map<Integer, Integer> cache = new HashMap<>();
//     Map<Integer, Integer> pair = new HashMap<>();

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//          }
    
//     public int get(int key) {
        
//     if (cache.containsKey(key)){
//         return key;
//     }
//     else 
//          return -1;     
//     }
    
//     public void put(int key, int value) {  
//         if(pair.containsKey(key)){
//          pair.replace(key,value);
//         }
//         else 
//          cache.replace(key, value);
        
//         } 
//     }


// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */

//or


class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




//or




class LRUCache {
    private int[] cacheMap_;
    private int[] prev_;
    private int[] next_;
    private int capacity_;
    private int size_;
    private int headKey_;
    private int tailKey_;
    
    public LRUCache(int capacity) {
        capacity_ = capacity;
        
        cacheMap_ = new int[10001];
        prev_ = new int[10001];
        next_ = new int[10001];
        
        for(int i = 0; i <= 10000; ++i) {
            cacheMap_[i] = -1;
        }
    }
    
    public int get(int key) {
        //System.out.println(size_);
        //System.out.println(key + ": " + cacheMap_[1] + " " + cacheMap_[2] + " " + cacheMap_[3] + " " + cacheMap_[4]);
        
        // the key presents in the cache
        if(cacheMap_[key] != -1 && size_ > 1) {
            if(key == headKey_) {
                int nextKey = next_[key];
                next_[tailKey_] = headKey_;
                prev_[headKey_] = tailKey_;
                tailKey_ = headKey_;
                headKey_ = nextKey;
            }
            else if(key != tailKey_) {
                int prevKey = prev_[key];
                int nextKey = next_[key];
                next_[prevKey] = nextKey;
                prev_[nextKey] = prevKey;
                
                next_[tailKey_] = key;
                prev_[key] = tailKey_;
                tailKey_ = key;
            }
        }
        
        return cacheMap_[key];
    }
    
    public void put(int key, int value) {
        if(cacheMap_[key] == -1) {
            cacheMap_[key] = value;
            
            if(size_ == capacity_) {
                cacheMap_[headKey_] = -1;
                headKey_ = next_[headKey_];
                size_--;
            }
            
            if(size_ == 0) {
                headKey_ = key;
                tailKey_ = key;
            }
            else {
                next_[tailKey_] = key;
                prev_[key] = tailKey_;
                tailKey_ = key;
            }
            
            size_++;
        }
        else {
            cacheMap_[key] = value;

            if(size_ > 1) {
                if(key == headKey_) {
                    int nextKey = next_[key];
                    next_[tailKey_] = headKey_;
                    prev_[headKey_] = tailKey_;
                    tailKey_ = headKey_;
                    headKey_ = nextKey;
                }
                else if(key != tailKey_) {
                    int prevKey = prev_[key];
                    int nextKey = next_[key];
                    next_[prevKey] = nextKey;
                    prev_[nextKey] = prevKey;

                    next_[tailKey_] = key;
                    prev_[key] = tailKey_;
                    tailKey_ = key;
                }
            }
        }
        
        // System.out.println(key + " " + value);
        // System.out.println(headKey_ + " " + tailKey_);
        // System.out.println(key + ": " + cacheMap_[1] + " " + cacheMap_[2] + " " + cacheMap_[3] + " " + cacheMap_[4]);
    }
}