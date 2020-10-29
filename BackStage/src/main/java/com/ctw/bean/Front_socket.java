package com.ctw.bean;

public class Front_socket {

	private String client_ip;
	private String client_port;
	private Integer socket_id;
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	public String getClient_port() {
		return client_port;
	}
	public void setClient_port(String client_port) {
		this.client_port = client_port;
	}
	public Integer getSocket_id() {
		return socket_id;
	}
	public void setSocket_id(Integer socket_id) {
		this.socket_id = socket_id;
	}
	@Override
	public String toString() {
		return "Front_socket [client_ip=" + client_ip + ", client_port=" + client_port + ", socket_id=" + socket_id
				+ "]";
	}
	
}
