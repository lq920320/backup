### MyBatis 批量更新 demo:

#### 方法一：

```
<update id="batchUpdate" parameterType="list">
	<foreach collection="list" separator=";" item="cus">
		UPDATE t_customer SET
		c_name = #{cus.name},
		c_age = #{cus.age},
		c_gender = #{cus.gender},
		c_ceroNo = #{cus.ceroNo},
		c_ceroType = #{cus.ceroType}
		WHERE id = #{cus.id}
	</foreach>
</update>
```

#### 方法二：

```
<update id="batchUpdate" parameterType="list">
	UPDATE t_room 
	SET breakfastNum = CASE id 
	<forearch collection="rooms" item="room">
		WHEN #{room.id} THEN #{room.breakfastNum}
	</foreach>
	END,
	SET breakfastTime = CASE id
	<foreach collection="rooms" item="room">
		WHEN #{room.id} THEN #{room.breakfastTime}
	</foreach>
	END
	WHERE id IN 
	<foreach collection="rooms" item="room" separator="," open="(" close=")">
		#{room.id}
	</foreach>
</update>
```
