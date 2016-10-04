package com.wayeasoft.deployer.model;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.wayeasoft.deployer.config.Config;

public abstract class Project
{
	
	public abstract void build() throws Exception;
	
	public Path getSrcPath()
	{
		Path path = Paths.get(Config.SRC_DIR,"abc", "123", name);
		if( !path.toFile().exists())
		{
			path.toFile().mkdirs();
		}
		return path;
	}
	//"svn update D:\\bhjs_package\\bhjs-aggr --username niyuzhe --password woshitiandade"
	public String getCheckoutCmd()
	{
		return "svn checkout " + scmUrl + " --username " + scmUsername + " --password " +  scmPassword + " " + getSrcPath().toString();
	}
	
	private String name;
	
	private String description;
	
	private String scmUrl;
	
	private String scmUsername;
	
	private String scmPassword;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getScmUrl()
	{
		return scmUrl;
	}

	public void setScmUrl(String scmUrl)
	{
		this.scmUrl = scmUrl;
	}

	public String getScmUsername()
	{
		return scmUsername;
	}

	public void setScmUsername(String scmUsername)
	{
		this.scmUsername = scmUsername;
	}

	public String getScmPassword()
	{
		return scmPassword;
	}

	public void setScmPassword(String scmPassword)
	{
		this.scmPassword = scmPassword;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

}
