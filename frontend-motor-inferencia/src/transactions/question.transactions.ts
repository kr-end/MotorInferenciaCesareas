import axios from "axios";
import { QuestionRequestDto, QuestionResponseDto } from "./dtos/cesarea.dto";
import { apiBaseUrl } from "../main";

export async function createQuestion(
  numQuestion: number,
  question: QuestionRequestDto
): Promise<QuestionResponseDto | any> {
  try {
    const response = await axios.post<QuestionResponseDto>(
      `${apiBaseUrl}/question/${numQuestion}`,
      question
    );

    return response.data as QuestionResponseDto;
  } catch (error) {
    return error;
  }
}
