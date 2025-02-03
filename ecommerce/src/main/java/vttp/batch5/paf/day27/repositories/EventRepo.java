package vttp.batch5.paf.day27.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day27.Utils;

@Repository
public class EventRepo {
    @Autowired @Qualifier(Utils.REDIS_TEMPLATE)
    private RedisTemplate<String, String> template;

    // SET EVENT <event id> {event details (json str)}
    public void saveEvent(String id, String json) {
        template.opsForHash().put(Utils.REDIS_HKEY_EVENT, id, json);
    }
}
