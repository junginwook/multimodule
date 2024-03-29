package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import dev.be.moduleapi.service.DemoService;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(Include.NON_NULL) //null인 값은 응답객체에 필드로 포함하지 않겠다.
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
	private String returnCode;
	private String returnMessage;
	private T info;

	public CommonResponse(CodeEnum codeEnum) {
		setReturnCode(codeEnum.getCode());
		setReturnMessage(codeEnum.getMessage());
	}

	public CommonResponse(T info) {
		setReturnCode(CodeEnum.SUCCESS.getCode());
		setReturnMessage(CodeEnum.SUCCESS.getCode());
		setInfo(info);
	}

	public CommonResponse(CodeEnum codeEnum, T info) {
		setReturnCode(codeEnum.getCode());
		setReturnMessage(codeEnum.getMessage());
		setInfo(info);
	}
}
