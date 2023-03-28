package com.formacion.core.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JSONResult<T>
{
	protected Boolean success;
	protected T response;

	public JSONResult()
	{
		this(Boolean.FALSE, null);
	}

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
