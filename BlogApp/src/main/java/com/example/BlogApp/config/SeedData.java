package com.example.BlogApp.config;

import com.example.BlogApp.models.Account;
import com.example.BlogApp.models.Authority;
import com.example.BlogApp.models.Post;
import com.example.BlogApp.services.AccountService;
import com.example.BlogApp.services.AuthorityService;
import com.example.BlogApp.services.PostService;
import com.example.BlogApp.util.constants.Privillages;
import com.example.BlogApp.util.constants.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for (Privillages auth : Privillages.values()) {
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);

        }

        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        account01.setEmail("meet@user.com");
        account01.setPassword("pass179");
        account01.setFirstname("Meet");
        account01.setLastname("Jain");
        account01.setAge(25);
        account01.setDate_of_birth(LocalDate.parse("2003-03-17"));
        account01.setGender("Male");


        account02.setEmail("saloni0927@gmail.com");
        account02.setPassword("pass917");
        account02.setFirstname("Saloni");
        account02.setLastname("Saboo");
        account02.setRole(Roles.ADMIN.getRole());
        account02.setAge(25);
        account02.setDate_of_birth(LocalDate.parse("2004-05-09"));
        account02.setGender("Female");

        account03.setEmail("jay@editor.com");
        account03.setPassword("password98");
        account03.setFirstname("Jay");
        account03.setLastname("Sharma");
        account03.setRole(Roles.EDITOR.getRole());
        account03.setAge(55);
        account03.setDate_of_birth(LocalDate.parse("1975-01-01"));
        account03.setGender("Male");

        account04.setEmail("khushi@editor.com");
        account04.setPassword("password92");
        account04.setFirstname("Khushi");
        account04.setLastname("Khandelwal");
        account04.setRole(Roles.EDITOR.getRole());
        account04.setAge(40);
        account04.setDate_of_birth(LocalDate.parse("1980-01-01"));
        account04.setGender("Female");


        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        account04.setAuthorities(authorities);

        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);


        List<Post> posts = postService.findAll();
        if (posts.size() == 0) {

            // Blog 1: AB de Villiers
            Post post01 = new Post();
            post01.setTitle("AB de Villiers – The 360° Batsman");
            post01.setBody("""
                        Abraham Benjamin de Villiers, fondly known as AB de Villiers, is one of the most versatile 
                        and innovative batsmen the cricketing world has ever seen. Nicknamed "Mr. 360" for his ability 
                        to play shots all around the ground, he has redefined modern batting with his unorthodox yet 
                        highly effective style. De Villiers has represented South Africa across formats and has also 
                        been a superstar in the Indian Premier League (IPL). 
                    
                        His consistency, humility, and game-changing performances have earned him the respect of 
                        cricket fans globally.
                    """);
            post01.setAccount(account01);
            postService.save(post01);

            // Blog 2: Atif Aslam
            Post post02 = new Post();
            post02.setTitle("Atif Aslam – The Voice of a Generation");
            post02.setBody("""
                        Atif Aslam is a Pakistani playback singer, songwriter, and actor, celebrated for his soulful 
                        and melodious voice. Rising to fame with hits like "Aadat," "Tera Hone Laga Hoon," and 
                        "Jeene Laga Hoon," he quickly became a household name not just in Pakistan but across India 
                        and worldwide. 
                    
                        His ability to infuse emotion into every note has made him one of the most beloved 
                        singers in South Asia. Atif continues to inspire millions with his music and live performances.
                    """);
            post02.setAccount(account02);
            postService.save(post02);

            // Blog 3: NCERT Mughals History Debate
            Post post03 = new Post();
            post03.setTitle("It was Wrong to Remove Mughals History from NCERT");
            post03.setBody("""
                        The recent decision to remove chapters on Mughal history from NCERT textbooks has sparked 
                        intense debate. The Mughal Empire, which ruled large parts of the Indian subcontinent for 
                        centuries, played a crucial role in shaping India's culture, architecture, and heritage. 
                    
                        Eliminating this history risks depriving students of a balanced understanding of India's 
                        diverse past. History should reflect the contributions of all communities, fostering 
                        inclusivity and awareness rather than selective memory.
                    """);
            post03.setAccount(account01);
            postService.save(post03);

            // Blog 4: Artificial Intelligence
            Post post04 = new Post();
            post04.setTitle("Artificial Intelligence – Shaping Our Future");
            post04.setBody("""
                        Artificial Intelligence (AI) is no longer a futuristic concept — it is shaping our present. 
                        From self-driving cars to virtual assistants, AI is revolutionizing industries and transforming 
                        how we live and work. 
                    
                        While it brings incredible opportunities for innovation, it also raises ethical concerns 
                        about privacy, job displacement, and decision-making. The future of AI depends on how wisely 
                        humanity integrates it into everyday life.
                    """);
            post04.setAccount(account02);
            postService.save(post04);

            // Blog 5: Climate Change Awareness
            Post post05 = new Post();
            post05.setTitle("Climate Change – A Call for Global Action");
            post05.setBody("""
                        Climate change is one of the biggest challenges of our time. Rising global temperatures, 
                        melting ice caps, and extreme weather events are urgent reminders of the need for action. 
                    
                        Governments, industries, and individuals must work together to reduce carbon emissions, 
                        embrace renewable energy, and protect biodiversity. Small lifestyle changes can collectively 
                        make a huge difference in saving our planet.
                    """);
            post05.setAccount(account01);
            postService.save(post05);

            // Blog 6: Mental Health Awareness
            Post post06 = new Post();
            post06.setTitle("Mental Health Matters – Breaking the Stigma");
            post06.setBody("""
                        Mental health is just as important as physical health, yet it is often neglected or stigmatized. 
                        Millions around the world suffer silently due to fear of judgment or lack of resources. 
                    
                        Talking openly about mental well-being, providing support systems, and making counseling accessible 
                        are key steps toward building a healthier society. Remember: seeking help is a sign of strength, 
                        not weakness.
                    """);
            post06.setAccount(account02);
            postService.save(post06);
        }
    }

}

