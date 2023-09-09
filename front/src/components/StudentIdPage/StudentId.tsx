import React, { useState } from "react";
import "./StudentId.css";
import sanghoon from "../../assets/sanghoon.png";
import SmartId from "../common/SmartId";
import styled from "styled-components";

const StudentIdComponent = styled.div`
  width: 90%;
  height: 20%;
  background-color: #fff;
  position: absolute;
  left: 5%;
  top: 7%;
  border-radius: 20px;
  border: solid 0.1rem;
  // 카드 돌릴 때 필요
  perspective: 1000px;
  transition: transform 0.6s linear;
  backface-visibility: hidden;
`;

const StudentId = () => {
  const [isFlipped, setIsFlipped] = useState(false);

  const handleClick = () => {
    setIsFlipped(!isFlipped);
  };

  const lsh = {
    name: "이상훈",
    major: "금속신소재공학과",
    grade: "2학년",
    number: 201403808,
  };
  return (
    <StudentIdComponent>
      {isFlipped ? (
        <div>
          <SmartId
            name={lsh.name}
            major={lsh.major}
            number={lsh.number}
            grade={lsh.grade}
          />
          <div className="flipment" onClick={handleClick}>
            카드 보기 &gt;
          </div>
        </div>
      ) : (
        <div className="flipped">
          <div className="back">
            <div className="cardInfo">
              <div>계좌번호: 93087254624787</div>
              <div>잔액: 500원</div>
            </div>
            <div className="flipment" onClick={handleClick}>
              학생증 앞면 보기 &gt;
            </div>
          </div>
        </div>
      )}
    </StudentIdComponent>
  );
};

export default StudentId;
