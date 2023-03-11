export default function ResetButton({resetCounter}) {
    return (
        <div className="ResetButton">
            <button className="resetButton"
                    onClick={resetCounter}
                >Reset</button>
        </div>
    )
    
}