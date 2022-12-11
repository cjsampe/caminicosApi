package com.sanvalero.cjs_caminicosApi.routes.model;

import com.sanvalero.cjs_caminicosApi.shared.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Blob;

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
    @Column(length = 2000)
    String description;
    @Column()
    float km;
    @Column()
    String season;
    @Column()
    int unevenness;
    @Column()
    String type;
    @Column()
    String time;
    @Column()
    String photo1;
    @Column()
    String photo2;
    @Column()
    String levelys;
    @Column()
    int max;
    @Column()
    int min;
    @Column()
    long level;

}
