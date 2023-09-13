import React, { useEffect, useState } from "react";
import StudentId from "../components/StudentIdPage/StudentId";
import MessageBox from "../components/RegisterFriendPage/MessageBox";
import useSendOneWon from "../hooks/useSendOneWon";
import api1 from "../utils/api1";

interface PageProps {
  text: string;
  height: number;
  onConfirm: (value: string) => void;
}

const RegisterFriendPage = () => {
  const [step, setStep] = useState(0);

  const { isSuccess, password, handleSendOneWon } = useSendOneWon();

  const registerFriend = (value: string) => {
    if (value === password) {
      console.log("일치합니다. 친구가 되셨습니다.");
    }
  };

  const pages: PageProps[] = [
    {
      text: "추가할 친구의 학번을 입력해주세요",
      height: 30,
      onConfirm: (value) => {
        handleSendOneWon(Number(value));
        // console.log(`학번은 ${value} 입니다.`);
        setStep((prevStep) => prevStep + 1);
        // 여기에 첫 번째 단계에서 수행할 로직을 작성합니다.
      },
    },
    {
      text: "친구에게 전송된 인증번호를 알려주세요",
      height: 40,
      onConfirm: (value) => {
        console.log(`입금자명은 ${value} 입니다.`);
        registerFriend(value);
      },
    },
  ];

  return (
    <div>
      <StudentId />
      <MessageBox
        height={pages[step].height}
        text={pages[step].text}
        onConfirm={pages[step].onConfirm}
        // onConfirm={() => setStep(step + 1)}
      />
    </div>
  );
};

export default RegisterFriendPage;
