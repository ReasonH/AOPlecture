package com.practice.aoplec.service.board;

import com.practice.aoplec.domain.board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary // boardservice 우선적 의존성 주입
public class BoardServicePerformance implements BoardService {

    @Autowired
    @Qualifier("boardServiceImpl")
    private BoardService boardService;

    @Override
    public List<Board> getBoards() {
        long start = before();
        List<Board> boards = boardService.getBoards();
        after(start);

        return boards;
    }

    private long before() {
        return System.currentTimeMillis();
    }

    private void after(long start) {
        long end = System.currentTimeMillis();
        System.out.println("수행 시간 : "+(end-start));
    }
}
