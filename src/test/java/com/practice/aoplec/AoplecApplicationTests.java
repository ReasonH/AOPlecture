package com.practice.aoplec;

import com.practice.aoplec.service.board.BoardService;
import com.practice.aoplec.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class AoplecApplicationTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void findBoards() throws Exception {
        assertThat(boardService.getBoards().size()).isEqualTo(100);
    }

}
