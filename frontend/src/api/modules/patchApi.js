import api from "@/api/index.js";

// param 객체를 받아 PATCH 요청을 보내는 함수
export const patchApi = async (param) => {
  try {
    const { data } = await api({
      method: "patch", // PATCH 메서드 선택
      url: param.url, // 요청할 URL 지정
      data: param.data, // 전달할 데이터 지정
    },
      { withCredentials: true });
    return data; // 응답 데이터 반환
  } catch (error) {
    // 요청 실패 시 오류 처리
    console.error("PATCH 요청 중 오류 발생:", error);
    throw error; // 오류를 다시 던짐
  }
};
