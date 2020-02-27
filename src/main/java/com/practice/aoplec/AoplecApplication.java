package com.practice.aoplec;

import com.practice.aoplec.aspect.Performance;
import com.practice.aoplec.domain.board.Board;
import com.practice.aoplec.domain.board.BoardRepository;
import com.practice.aoplec.domain.user.User;
import com.practice.aoplec.domain.user.UserRepository;
import com.practice.aoplec.service.board.BoardService;
import com.practice.aoplec.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
public class AoplecApplication implements CommandLineRunner {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        for(int i=1; i<=100; i++){
            boardRepository.save(new Board(i+"번째 게시글 제목", i+"번째 게시글의 내용"));
            userRepository.save(new User(i+"@email.com", i+"번째 사용자"));
        }
    }

    @GetMapping("/boards")
    public List<Board> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    public static void main(String[] args) {
        SpringApplication.run(AoplecApplication.class, args);
    }

    @Bean
    public Performance performance() {
        return new Performance();
    }
}
