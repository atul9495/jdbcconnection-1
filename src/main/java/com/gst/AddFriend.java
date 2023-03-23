package com.gst;

 
 import com.artcode.atul.*;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

 
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "add_friend")
public class AddFriend implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "friend_id")
	private Long friendId;

 

	@Column(name = "req_status")
	private String requestStatus;

	@ColumnDefault("0")
	@Column(name = "blocked")
	private boolean blocked;

	@ColumnDefault("0")
	@Column(name = "blocked_by")
	private boolean blockedBy;

	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", updatable = false)
	private Date createdAt;

	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public AddFriend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddFriend( String requestStatus, boolean blocked, boolean blockedBy) {
		super();
	 
		this.requestStatus = requestStatus;
		this.blocked = blocked;
		this.blockedBy = blockedBy;
	}

	public Long getFriendId() {
		return friendId;
	}

	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}

	 

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public boolean isBlockedBy() {
		return blockedBy;
	}

	public void setBlockedBy(boolean blockedBy) {
		this.blockedBy = blockedBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "AddFriend [friendId=" + friendId + ", friendUserId=" 
				+ ", requestStatus=" + requestStatus + ", blocked=" + blocked + ", blockedBy=" + blockedBy
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
