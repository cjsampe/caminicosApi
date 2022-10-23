package com.sanvalero.cjs_caminicosApi.routes.model;

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

Route extends BaseModel {
    @Column()
    String village;
    @Column()
    String province;
    @Column(length = 500)
    String title;
    @Column(length = 3000)
    String description;
    @Column()
    float km;
    @Column()
    String signaling;
    @Column()
    String season;
    @Column()
    int unevenness;
    @Column()
    Boolean circular;
    @Column()
    String time;

}
