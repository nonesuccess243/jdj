package com.wayeasoft.deployer.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class War extends Project
{

	@Override
	public void build() throws Exception
	{
		String cmd = getCheckoutCmd();
		
		System.out.println(cmd);
		
		Runtime run = Runtime.getRuntime();
		
		Process p = run.exec(cmd);

		BufferedInputStream in = new BufferedInputStream(p.getInputStream());
		BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
		String lineStr;
		while ((lineStr = inBr.readLine()) != null)
			// 获得命令执行后在控制台的输出信息
			System.out.println(lineStr);// 打印输出信息
		// 检查命令是否执行失败。
		if (p.waitFor() != 0)
		{
			if (p.exitValue() == 1)// p.exitValue()==0表示正常结束，1：非正常结束
				System.err.println("命令执行失败!");
		}
		inBr.close();
		in.close();
		
	}

}
