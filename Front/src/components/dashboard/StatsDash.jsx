import React from "react";

export default function StatsDash(props) {
    return (
        <>
            <div className="stat_icon">
                <img src={props.img} className="StatsDash_img"/>
                <h3 className="StatsDash_result">{props.result}</h3>
                <h3 className="StatsDash_desc">{props.desc}</h3>
            </div>

        </>
    )
}