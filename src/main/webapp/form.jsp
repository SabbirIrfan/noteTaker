<form action="savenoteservlet" method="post">
    <div class="form-group formPad">
        <label for="tittle">Note Tittle</label>
        <input type=text class="form-control" id="tittle" name="tittle" required aria-describedby="emailHelp" placeholder="Tittle Goes Here">
        <small id="emailHelp" class="form-text text-muted">We'll never share your Notes with anyone else But why should you believe anything I promise</small>

    </div>
    <div class="form-group formPad">
        <label for="content">Content</label>
        <textarea  class="form-control noteContainer" id="content" name="content" required>
            Your Notes...

        </textarea>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
