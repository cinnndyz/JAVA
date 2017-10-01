package entity;

import java.io.Serializable;
import java.util.Date;

public class Subscription_dtl implements Serializable{
	private Integer id;
	private Integer rid;
	private Integer sid;
	private Date sdate;
	private Date edate;
	private Integer residetype;
	private float price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public Integer getResidetype() {
		return residetype;
	}
	public void setResidetype(Integer residetype) {
		this.residetype = residetype;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
