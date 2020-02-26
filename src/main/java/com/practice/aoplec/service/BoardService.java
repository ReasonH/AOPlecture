package com.practice.aoplec.service;

import com.practice.aoplec.domain.board.Board;
import com.practice.aoplec.domain.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getBoards() {
        return boardRepository.findAll();
    }
}
