package com.inditex.zara.apimodel.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JSONResult<T>
{
	protected Boolean success;
	protected T response;

	public JSONResult(Boolean success, T response)
	{
		this.success = success;
		this.response = response;
	}

	public JSONResult(T result)
	{
		this(Boolean.TRUE,result);
	}
}
