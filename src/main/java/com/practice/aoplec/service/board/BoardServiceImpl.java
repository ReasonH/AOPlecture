package com.practice.aoplec.service.board;

import com.practice.aoplec.domain.board.Board;
import com.practice.aoplec.domain.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository repository;

    @Override
    public List<Board> getBoards() {
        return repository.findAll();
    }
}
