package com.piyush.bootmongo.com.piyush.bootmongo.controller;

import com.piyush.bootmongo.com.piyush.bootmongo.repository.UserRepository;
import com.piyush.bootmongo.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/")
public class UserContorller {

    private final Logger Log = LoggerFactory.getLogger(getClass());
    private final UserRepository userRepository;

    public UserContorller(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /*@RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        Log.info("Getting all users.");
        return userRepository.findAll();
    }*/

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        Log.info("Getting all users.");
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable String userId){
        Log.info("Getting specific user");
        return userRepository.findById(userId);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public User addNewUsers(@RequestBody User user){
        Log.info("saving user");
        return userRepository.save(user);
    }

    @RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
    public Object getAllUserSettings(@PathVariable String userId){
        Log.info("get all user settings");
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        if(user != null){
            return user.getUsetSettings();
        }else{
            return "User not found";
        }
    }

    @RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.GET)
    public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value){
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();

        if(user != null){
            user.getUsetSettings().put(key, value);
            userRepository.save(user);
            return "Key Added";
        } else {
            return "User not found";
        }
    }
}
