package com.onlineExam.service;

import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.SimpleResult;

public interface PaperService {

    SimpleResult submitPaper(String userId,String paperId,String answer,String questionNos);

    DataResult paperHistory(String title);
}
