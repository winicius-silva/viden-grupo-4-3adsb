import React from "react";


export default function Card(props){
    return(
        <>
            <div className={props.color}>
                <img src={props.img} alt="" />
                <h3>{props.title}</h3>
                <br />
                <h4>{props.desc}</h4>
            </div>
        </>   
    );
}