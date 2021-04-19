package com.example.demo.rest;


import com.example.demo.base.The_week;
import com.example.demo.constants.Constants;
import com.example.demo.core.CustomUserDetails;
import com.example.demo.core.RequestLogin;
import com.example.demo.dto.ObjectDTO;
import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.jwt.JwtResponse;
import com.example.demo.model.Object;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repos.common.TestFunctional;
import com.example.demo.service.impl.ObjectServiceImpl;
import com.example.demo.service.impl.RoleServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import io.jsonwebtoken.lang.Assert;


import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class Test {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private RoleServiceImpl roleServiceImpl;
    @Autowired
    private ObjectServiceImpl objectServiceImpl;
    @Autowired
    private AuthenticationProvider authenticationProvider;


    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody RequestLogin requestLogin) throws Exception
    {
//        requestLogin.setUsername("tupv");
//        requestLogin.setPassword("123456");
        String passwordSha256 = Hashing.sha256().hashString(requestLogin.getPassword(),StandardCharsets.UTF_8).toString();
        String password = "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
        System.out.println(passwordSha256);
        UserDTO currentUser = null;
        try{
            currentUser = userServiceImpl.getUserByUserName(requestLogin.getUsername()).toModel();
        }catch (Exception e) {
        }
        // Xác thực từ username và password.
        Authentication authentication = authenticationProvider
                .authenticate(new UsernamePasswordAuthenticationToken(requestLogin, requestLogin.getPassword()));
        Assert.notNull(authentication, "abc");

        // Nếu thông tin hợp lệ Set thông tin authentication vào Security Context
        // SecurityContextHolder.getContext().setAuthentication(authentication);

        LocalDateTime localDateTime = LocalDateTime.now();
        Date updateDate = Date.from(localDateTime.toInstant(ZoneOffset.UTC));

        // Trả về jwt cho người dùng.
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwt = customUserDetails.getJwt();
        // userServiceImpl.resetLoginFailCount(customUserDetails.getUsername());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(Constants.HEADER_NAME, "Bearer " + jwt);
        return new ResponseEntity<>(new JwtResponse(jwt, customUserDetails.getUser()), httpHeaders, HttpStatus.OK);
//        return null;

    }
    @GetMapping("/test")
    public String getList()
    {
        Map<String,UserDTO> testTreeMap = new TreeMap();

        Set<UserDTO> testSet = new HashSet<UserDTO>();
        List<UserDTO> rs = new ArrayList<>();
        rs.add(new UserDTO("tupv","uytuihfkdjsf"));
        rs.add(new UserDTO("thangtv","uytuihfkdjsf"));
        rs.add(new UserDTO("vietlv","uytuihfkdjsf"));
        rs.forEach(e ->{
            testSet.add(e);
        });
        Map<String,UserDTO> hashMap = new HashMap<>();
        hashMap.put("abc",new UserDTO("userTest1","123456"));
        hashMap.put("abc",new UserDTO("userTest2","123456"));
//        hashMap.put()

        UserDTO user1
                = new UserDTO();
//        user
//        user1.setTotal(132);
//        user1.seeMessage();
        System.out.println(The_week.MONDAY.getName());
        UserDTO userTest = hashMap.get(null);
        rs.sort((UserDTO obj1,UserDTO obj2) -> obj1.getUserName().compareToIgnoreCase(obj2.getUserName()));
        Stream<UserDTO> rsStream = rs.stream().filter( e -> e.getUserName().startsWith("t"));
        rs.stream().forEach(e -> hashMap.put(e.getUserName(),e));
        Set<String> key = hashMap.keySet();
        Iterator iterator = rs.stream().iterator();
        do{
            UserDTO userDto = (UserDTO) iterator.next();
            System.out.println(userDto.getUserName()+"_abc");
        }
        while(iterator.hasNext());
        key.forEach(e -> System.out.println(e));
        Long count = rsStream.count();
        List<UserDTO> lstFilter = rs.stream().filter( e -> e.getUserName().startsWith("t")).collect(Collectors.toList());
        System.out.println(rs);
        String userName ="tupv";
        String password ="8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
        TestFunctional e = (name) ->{
            User user = userServiceImpl.getUserByUserName(name);
            return user == null ? new UserDTO() : user.toModel();
        };
//        var nameada = "";

        UserDTO userDTO = e.sayHello(userName);
//        System.out.println(userDTO.getUserName());
//        System.out.println(userDTO.getListRole());
//        System.out.println(userDTO.getListObject());
        System.out.println(e.sayHello(userName).toString());
        User user = userServiceImpl.getUserByUserName(userName);
        List<User> getList = userServiceImpl.getListUsers(password);
        for (User item: getList) {
            System.out.println(item.getUserName()+ " "+ item.getPassWord());
        }
        List<ObjectDTO> getListObject = objectServiceImpl.getListObject(1l);
        List<RoleDTO> getListRole = roleServiceImpl.getListRole(1l);
        for(RoleDTO item : getListRole){
            System.out.println(item.getRoleName());
        }
        for(ObjectDTO item:getListObject){
            System.out.println(item.getObjectName()+" "+item.getObjectCode());
        }
        System.out.println(user.getUserName());
//        return new ResponseEntity<?>..ok(user);
        return "abc afsafsdfs" +" " + user.toString();
    }
}
