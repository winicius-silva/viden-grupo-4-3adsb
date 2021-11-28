import React from "react";

export default function Aulas(props) {
    return (
        <>
            <div className="container_video">

                <div className="videoPlayer">
                    

                </div>

                <div className="aulas_right">

                    <select name="" id="">
                        <option value="">
                            <div className="vid_1">
                                <div id="aula"><iframe src={props} frameborder="0"></iframe></div>
                            </div>
                        </option>
                    </select>
                    

                    <div className="vid_1">
                        <div id="aula"><iframe src={props} frameborder="0"></iframe></div>
                    </div>

                    <div className="vid_1">
                        <div id="aula"><iframe src={props} frameborder="0"></iframe></div>
                    </div>

                    <div className="vid_1">
                        <div id="aula"><iframe src={props} frameborder="0"></iframe></div>
                    </div>
                    
                    <div className="vid_1">
                        <div id="aula"><iframe src={props} frameborder="0"></iframe></div>
                    </div>

                </div>
            </div>


        </>
    )

}