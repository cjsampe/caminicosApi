package com.sanvalero.cjs_caminicosApi.post.model;

import com.sanvalero.cjs_caminicosApi.shared.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data()
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class

Post extends BaseModel {
    @Column()
    String user;
    @Column(length = 1000)
    String post;
    @Column()
    long route;
}
