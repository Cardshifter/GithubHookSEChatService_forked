package com.skiwi.githubhooksechatservice.events.github.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RateLimitResponse {
	
	@JsonProperty
	private RateLimitResources resources;
	
	@JsonProperty
	private RateLimit rate;
	
	public RateLimit getRate() {
		return rate;
	}
	
	public RateLimitResources getResources() {
		return resources;
	}
	
	public static class RateLimitResources {
		@JsonProperty
		private RateLimit core;
		
		@JsonProperty
		private RateLimit search;
		
		public RateLimit getCore() {
			return core;
		}
		
		public RateLimit getSearch() {
			return search;
		}
	}
	
	public static class RateLimit {
		
		@JsonProperty
		private int limit;
		
		@JsonProperty
		private int remaining;
		
		@JsonProperty
		private long reset;
		
		public int getLimit() {
			return limit;
		}
		
		public int getRemaining() {
			return remaining;
		}
		
		public long getReset() {
			return reset;
		}
		
	}
	
}
