package com.practice.aoplec.service.board;

import com.practice.aoplec.domain.board.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    List<Board> getBoards();
}
