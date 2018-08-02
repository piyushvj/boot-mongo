package com.piyush.bootmongo.com.piyush.bootmongo.repository;

import com.piyush.bootmongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserDALImpl implements UserDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> getAllUsers(){
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUserById(String userId){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public User addNewUser(User user){
        mongoTemplate.save(user);
        return user;
    }

    @Override
    public Object getAllUserSettings(String userId){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    @Override
    public String getUserSetting(String userId, String key){
        Query query = new Query();
        query.fields().include("userSettings");
        query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("userSettings."+key).exists(true)));
        User user = mongoTemplate.findOne(query, User.class);
        return user != null ? user.getUsetSettings().get(key) : "Not Found";
    }

    @Override
    public String addUserSetting(String userId, String key, String value){

        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));

        User user = mongoTemplate.findOne(query, User.class);
        if(user != null) {
            user.getUsetSettings().put(key, value);
            mongoTemplate.save(user);
            return "Key Added";
        }else{
            return "User not found";
        }
    }


}
